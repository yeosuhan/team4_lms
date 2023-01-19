(function($) {

	"use strict";

	// Setup the calendar with the current date
	$(document).ready(
			function() {
				var date = new Date();
				var today = date.getDate();
				// Set click handlers for DOM elements
				$(".right-button").click({
					date : date
				}, next_year);
				$(".left-button").click({
					date : date
				}, prev_year);
				$(".month").click({
					date : date
				}, month_click);
				$("#add-button").click({
					date : date
				});
				// Set current month as active
				$(".months-row").children().eq(date.getMonth()).addClass(
						"active-month");
				init_calendar(date);
				var events = check_events(today, date.getMonth() + 1, date
						.getFullYear());
				show_events(events, months[date.getMonth()], today);
			});

	// Initialize the calendar by appending the HTML dates
	function init_calendar(date) {
		$(".tbody").empty();
		$(".events-container").empty();
		var calendar_days = $(".tbody");
		var month = date.getMonth();
		var year = date.getFullYear();
		var day_count = days_in_month(month, year);
		var row = $("<tr class='table-row'></tr>");
		var today = date.getDate();
		// Set date to 1 to find the first day of the month
		date.setDate(1);
		var first_day = date.getDay();
		// 35+firstDay is the number of date elements to be added to the dates
		// table
		// 35 is from (7 days in a week) * (up to 5 rows of dates in a month)
		for (var i = 0; i < 35 + first_day; i++) {
			// Since some of the elements will be blank,
			// need to calculate actual date from index
			var day = i - first_day + 1;
			// If it is a sunday, make a new row
			if (i % 7 === 0) {
				calendar_days.append(row);
				row = $("<tr class='table-row'></tr>");
			}
			// if current index isn't a day in this month, make it blank
			if (i < first_day || day > day_count) {
				var curr_date = $("<td class='table-date nil'>" + "</td>");
				row.append(curr_date);
			} else {
				var curr_date = $("<td class='table-date'>" + day + "</td>");
				var events = check_events(day, month + 1, year);
				if (today === day && $(".active-date").length === 0) {
					curr_date.addClass("active-date");
					show_events(events, months[month], day);
				}
				// If this date has any events, style it with .event-date
				if (events.length !== 0) {
					curr_date.addClass("event-date");
				}
				// Set onClick handler for clicking a date
				curr_date.click({
					events : events,
					month : months[month],
					day : day,
					year : year
				}, date_click);
				row.append(curr_date);
			}
		}
		// Append the last row and set the current year
		calendar_days.append(row);
		$(".year").text(year);
	}

	// Get the number of days in a given month/year
	function days_in_month(month, year) {
		var monthStart = new Date(year, month, 1);
		var monthEnd = new Date(year, month + 1, 1);
		return (monthEnd - monthStart) / (1000 * 60 * 60 * 24);
	}

	// Event handler for when a date is clicked
	function date_click(event) {
		$(".events-container").show(250);
		$(".active-date").removeClass("active-date");
		$(this).addClass("active-date");

		$.ajax({
			type : 'GET',
			url : "/lecture",
			data : {
				day : event.data.day,
				month : event.data.month,
				year : event.data.year
			},
			dataType : "json",
			error : function() {
				console.log('통신실패');
			},
			success : function(data) {
				show_events(data);
			}
		});
	}

	// Event handler for when a month is clicked
	function month_click(event) {
		$(".events-container").show(250);
		var date = event.data.date;
		$(".active-month").removeClass("active-month");
		$(this).addClass("active-month");
		var new_month = $(".month").index(this);
		date.setMonth(new_month);
		init_calendar(date);
	}

	// Event handler for when the year right-button is clicked
	function next_year(event) {
		var date = event.data.date;
		var new_year = date.getFullYear() + 1;
		$("year").html(new_year);
		date.setFullYear(new_year);
		init_calendar(date);
	}

	// Event handler for when the year left-button is clicked
	function prev_year(event) {
		var date = event.data.date;
		var new_year = date.getFullYear() - 1;
		$("year").html(new_year);
		date.setFullYear(new_year);
		init_calendar(date);
	}

	// Display all events of the selected date in card views
	function show_events(data) {
		var attendance = 0; // 출석
		var late = 0; // 지각
		var absence = 0; // 결석
		for (var i = 0; i < data.length; i++) {
			if (data[i].attendanceStatus == 1) {
				attendance++;
			} else if (data[i].attendanceStatus == 0) {
				absence++;
			} else if (data[i].attendanceStatus == 2) {
				late++;
			}
		}
		$(event_card).css({
			"border-left" : "10px solid #FF1744"
		});
		$(event_name).css({
			"font-size" : "15px"
		});
		$(event_body).css({
			"border-left" : "10px solid #FF1744"
		});
		$(event_content).css({
			"font-size" : "15px"
		});
		// Clear the dates container
		console.log(event_data["events"]);
		// If there are no events for this date, notify the user
		var event_card = $("<div class='event-card'></div>");
		var event_body = $("<div class='event-body'></div>");
		var AttPer = (attendance / data.length * 100);
		if (data.length == 0) {
			AttPer = 0;
		}
		var event_name = $("<div class='event-name' style='font-size:15px;'>출석률 : "
				+ parseInt(AttPer)
				+ "% | 출석: "
				+ attendance
				+ "명 결석: "
				+ absence + "명 지각: " + late + "명</div>");
		$(event_card).append(event_name);
		console.log("총 인원: " + data.length);
		console.log("출석한 사람: " + attendance);
		for (var i = 0; i < data.length; i++) {
			console.log(data[i]);
			var event_content = $("<div class='event-content'>"
					+ data[i].memberName + " - " + data[i].title + "</div>");
			$(event_body).append(event_content);
		}
		$(".events-container").empty();
		$(".events-container").show(250);
		$(".events-container").append(event_card);
		$(".events-container").append(event_body);
		
	}

	// Checks if a specific date has any events
	function check_events(day, month, year) {
		var events = [];
		for (var i = 0; i < event_data["events"].length; i++) {
			var event = event_data["events"][i];
			if (event["day"] === day && event["month"] === month
					&& event["year"] === year) {
				events.push(event);
			}
		}
		return events;
	}
	var event_data = {
		    "events": [
		    {
		        "occasion": " Repeated Test Event ",
		        "invited_count": 120,
		        "year": 2020,
		        "month": 5,
		        "day": 10,
		        "cancelled": true
		    }
		    ]
		};
	const months = [ "January", "February", "March", "April", "May", "June",
			"July", "August", "September", "October", "November", "December" ];

})(jQuery);
