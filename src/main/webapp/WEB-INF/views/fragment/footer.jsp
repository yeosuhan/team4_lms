<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
       <!-- Footer-->
        <footer class="footer py-4">
            <div class="container">
                <div class="row align-items-center">
                    <div class="col-lg-4 text-lg-start">Copyright &copy; TEAM4 2023</div>
                    <div class="col-lg-4 my-3 my-lg-0">
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Twitter" id="twitter" onclick="twitter()"><i class="fab fa-twitter"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="Facebook" id="facebook" onclick="facebook()"><i class="fab fa-facebook-f"></i></a>
                        <a class="btn btn-dark btn-social mx-2" href="#!" aria-label="LinkedIn" id="naver" onclick="naver()"><b>N</b></a>
                    </div>
                    <div class="col-lg-4 text-lg-end">
                        <a class="link-dark text-decoration-none me-3" href="#!">LMS</a>
                        <a class="link-dark text-decoration-none" href="#!">OTI UNIVERSITY</a>
                    </div>
                </div>
            </div>
        </footer>       
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="home/js/scripts.js"></script>

        <script src="https://cdn.startbootstrap.com/sb-forms-latest.js"></script>
        
        <script>
		$(function() {    //ready event
			//Element 메소드를 이용해서 이벤트 핸들러 추가
			const url = encodeURI(window.location.href);
			document.querySelector("#twitter").addEventListener("click", function() {
	        	const text = 'url연결'
	        	window.open("https://twitter.com/intent/tweet?text=" + text + "&url=" +  url, "_blank");
			});
			document.querySelector("#facebook").addEventListener("click", function() {
				window.open("http://www.facebook.com/sharer/sharer.php?u=" + url, "_blank");
			});
			document.querySelector("#naver").addEventListener("click", function() {
				window.open("http://share.naver.com/web/shareView.nhn?url=" + url +"&title=share", "_blank");
			});
		});
		
		function twitter(){
			const url = encodeURI(window.location.href);
			const text = 'url연결'
	        	window.open("https://twitter.com/intent/tweet?text=" + text + "&url=" +  url, "_blank");
		}
		
		function facebook(){
			const url = encodeURI(window.location.href);
			window.open("http://www.facebook.com/sharer/sharer.php?u=" + url, "_blank");
		}
		
		function naver(){
			const url = encodeURI(window.location.href);
			window.open("http://share.naver.com/web/shareView.nhn?url=" + url +"&title=share", "_blank");
		}
		
        </script>
    </body>
</html>