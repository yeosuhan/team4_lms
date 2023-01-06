<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/fragment/head.jsp" %>

<%@ include file="/WEB-INF/views/fragment/nav.jsp" %>
<html>
<head>
	<title>board</title>
	<style>
	@import url("https://fonts.googleapis.com/css2?family=Audiowide&family=Open+Sans&display=swap");
@import url("https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap");

$neonblue: #001eff;
$neonlightblue: #4deeea;
$neonyellow: #ffe700;
$neongreen: #74ee15;

*,
::before,
::after {
	padding: 0;
	margin: 0;
	box-sizing: border-box;
}

body {
	width: 100%;
	height: 100%;
	background-color: #101b37;
	display: grid;
	place-items: center;
}

h1,
h2,
h3,
h4,
h5,
h6 {
	font-family: "Audiowide", sans-serif;
	letter-spacing: 0.1em;
}

h2 {
	color: white;
	text-shadow: 0 0 0.5em $neonlightblue, 0 0 1em white;
	padding: 1em 0 0.5em 0;
}

figure {
	display: flex;
	position: relative;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	margin: 1em 0;

	img {
		object-fit: contain;
		width: 100%;
		max-width: 400px;
		height: auto;
		border-radius: 0 0.5em 0.5em 0;
		box-shadow: -0.5em 0.5em 0 $neongreen;
	}

	figcaption {
		position: absolute;
		font-family: "Open Sans", sans-serif;
		padding: 0.4em;
		font-size: 0.8rem;
		color: black;
		font-weight: bold;
		background-color: $neonyellow;
		border-radius: 0.5em;
		bottom: -1em;
	}
}

p {
	font-family: "Open Sans", sans-serif;
	line-height: 2em;
	padding: 0.5em 0;
}

.main {
	color: #fff;
	position: relative;
	max-width: 800px;

	@media screen and (min-width: 800px) {
		border-left: 0.1em solid white;
	}
}

.head {
	position: relative;
	padding: 1.5em;
	margin-bottom: 1em;
	/*background: linear-gradient(
    0deg,
    rgba(16, 27, 55, 1) 32%,
    rgba(0, 0, 0, 1) 100%
  );*/
}

.headline {
	position: relative;
	font-size: 2.5rem;
	color: white;
	text-shadow: 0 0 0.5em $neonlightblue, 0 0 1em white;
	border-top: 0.6rem solid $neonlightblue;
	border-right: 0.6rem solid $neongreen;
	border-bottom: 0.6rem solid magenta;
	border-radius: 0 1rem 1rem 0;
	padding: 0.8em 0em;
	text-transform: uppercase;

	&::before {
		content: "";
		width: 1.5rem;
		height: 1.5rem;
		border-radius: 50%;
		position: absolute;
		background-color: $neonlightblue;
		top: -1.05rem;
		left: -0.25rem;
	}
}

.subhead {
	position: relative;
	margin-bottom: 1em;
	text-shadow: none;
	color: white;
	padding: 1em;
	border-left: 0.6rem solid $neonyellow;
	font-family: "Open Sans", sans-serif;

	&::after {
		content: "";
		width: 1.5rem;
		height: 1.5rem;
		border-radius: 50%;
		position: absolute;
		background-color: $neonyellow;
		bottom: -0.35rem;
		left: -1.05rem;
	}
}

.article-meta {
	display: grid;
	flex-direction: column;
}

.author {
	position: relative;
	display: flex;
	align-items: center;
	padding: 1em;
	border-left: 0.6rem solid $neonblue;

	&::before {
		content: "";
		width: 1.5rem;
		height: 1.5rem;
		border-radius: 50%;
		position: absolute;
		background-color: $neonblue;
		top: -0.7rem;
		left: -1.05rem;
	}

	&::after {
		content: "";
		width: 1.5rem;
		height: 1.5rem;
		border-radius: 50%;
		position: absolute;
		background-color: $neonblue;
		bottom: -0.7em;
		left: -1.05em;
	}

	&__info {
		display: flex;
		flex-direction: column;
		margin-left: 1em;

		p {
			padding: 0;
		}
	}
}

.byline {
	font-weight: bold;
}

.article-tags {
	margin-top: 2em;
	padding: 0;

	span {
		padding: 0.5em 1em;
		background-color: black;
		border-radius: 1em;
	}
}

.content {
	padding: 1em 1.5em;
	//max-width: 70%;
	justify-self: center;
}

aside {
	position: relative;
	font-style: italic;
	color: white;
	margin: 1.5em 0;
	padding-left: 1em;
	border-left: 0.6rem solid $neonlightblue;
	text-align: left;

	&::before {
		content: "";
		width: 1.5rem;
		height: 1.5rem;
		border-radius: 50%;
		position: absolute;
		background-color: $neonlightblue;
		top: -0.7rem;
		left: -1.05rem;
	}

	&::after {
		content: "";
		width: 1.5rem;
		height: 1.5rem;
		border-radius: 50%;
		position: absolute;
		background-color: $neonlightblue;
		bottom: -0.7em;
		left: -1.05em;
	}
}
	
	</style>
</head>
<body>
	<div class="main">
	<div class="head">
		<h1 class="headline">게시판</h1>
		<h2 class="subhead">
			게시글 제목
		</h2>
		<div class="article-meta">
			<div class="author">
				<svg id="author-avatar" viewBox="0 0 36 36" fill="none" xmlns="http://www.w3.org/2000/svg" width="80" height="80">
					<title id="avatarTitle">Author Avatar</title>
					<desc id="avatarDesc">
						A cartoon avatar of a smiling purple square on a blue
						background.
					</desc>
					<mask id="mask__beam" maskUnits="userSpaceOnUse" x="0" y="0" width="36" height="36">
						<rect width="36" height="36" rx="72" fill="white"></rect>
					</mask>
					<g mask="url(#mask__beam)">
						<rect width="36" height="36" fill="#0ebeff"></rect>
						<rect x="0" y="0" width="36" height="36" transform="translate(6 6) rotate(192 18 18) scale(1)" fill="#754cac" rx="6"></rect>
						<g transform="translate(0 2) rotate(-2 18 18)">
							<path d="M13,19 a1,0.75 0 0,0 10,0" fill="white"></path>
							<rect x="12" y="14" width="1.5" height="2" rx="1" stroke="none" fill="white"></rect>
							<rect x="22" y="14" width="1.5" height="2" rx="1" stroke="none" fill="white"></rect>
						</g>
					</g>
				</svg>
				<div class="author__info">
					<p class="byline">작성자: Penny Pen</p>
					<p class="dateline">작성 일자: June 21, 2021</p>
				</div>
			</div>
			<p class="article-tags">
				<span class="tag">조회수: 0</span> <span class="tag">좋아요 수: 0</span>
				<span class="tag featured">좋아요</span>
			</p>
		</div>
	</div>
	<div class="content">
		<p>
			Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis
			quidem est minima quam! Laborum odit quidem earum perferendis eius
			laudantium perspiciatis similique deleniti delectus suscipit, cum
			corrupti facere reprehenderit esse.
		</p>
		<p>
			Animi aut, atque quibusdam similique distinctio enim iure, blanditiis
			rerum autem illum eum in. Dolorem quasi aspernatur nemo deserunt quo,
			libero dolore atque magni, ullam nihil corrupti et illo earum?
		</p>
		<p>
			Quos, ad? Et, iure. Officia fuga unde quibusdam nemo modi perspiciatis
			quisquam consectetur voluptates, dolore ab eaque voluptatem corporis
			placeat consequatur itaque qui asperiores. Consequuntur quas vitae
			animi est ea!
		</p>
		<p>
			Accusantium nemo labore corrupti laudantium! Quo reprehenderit ea
			perspiciatis temporibus! Illo sapiente harum fuga molestias temporibus
			iste animi. Velit, tenetur mollitia sit magni nulla quos veniam
			molestias consectetur aliquam eaque.
		</p>
		<p>
			Voluptatem, omnis, placeat recusandae iste explicabo accusantium velit
			laboriosam voluptatum similique, fugit culpa enim! Suscipit labore
			odit porro assumenda, molestiae aperiam laboriosam explicabo nemo
			soluta facere sed libero magnam. Odio.
		</p>

		<aside>
			<p>Quos, ad? Et, iure. Libero dolore atque magni.</p>
		</aside>

		<figure>
			<img src="https://assets.codepen.io/t-1/freddy-g-lhy1lY3CyLI-unsplash.jpg" alt="a smiling person in a pink hoodie, standing in front of a bright pink lighted arcade basketball game. " />
			<figcaption>Photo by Freddy G</figcaption>
		</figure>
		<!-- full size image: https://images.unsplash.com/flagged/photo-1556339911-7ef846e7db43-->
		
	</div>
</div>

</body>
</html>
<%@ include file="/WEB-INF/views/fragment/footer.jsp" %>
