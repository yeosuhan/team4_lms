<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
	<title>board</title>
	<style>
	body {
	font-family: "Poppins", sans-serif;
	font-weight: 400;
	color: #2c2c2c;
}

html,
body {
	margin: 0;
	padding: 0;
}

strong,
.fw-700 {
	font-weight: 700;
}

h1 {
	font-family: "Playfair Display", serif;
	font-size: 9rem;
	font-weight: 700;
}
h2 {
	font-family: "Playfair Display", serif;
	font-size: 3rem;
	font-weight: 700;
	font-style: italic;
}

.lead {
	font-size: 1.5rem;
	font-weight: 400;
}
	
	</style>
</head>
<body>
	<div class="overflow-hidden">
	<div class="container position-relative">
		<article class="z-index-1 position-relative">
			<header class="py-7">
				<a href="#" class="btn-arrow-left fw-700 text-decoration-none mb-5 d-inline-block">All posts</a>
				<h1 class="headline">게시글 제목</h1>
				<h2 class="subhead w-70 mb-6">The next generation of arcade gamers top the leaderboard</h2>
				<p class="article-tags">
					<span class="tag rounded-pill me-2 fw-700 bg-primary text-white shadow-lg py-2 px-3 small featured">featured</span>
					<span class="tag rounded-pill me-2 fw-700 bg-white shadow-lg py-2 px-3 small">culture</span>
					<span class="tag rounded-pill me-2 fw-700 bg-white shadow-lg py-2 px-3 small">games</span>
				</p>
			</header>

			<div class="article-meta d-flex justify-content-between mb-6">
				<div id="author" class="center-v">
					<svg id="author-avatar" class="me-3" viewBox="0 0 36 36" fill="none" xmlns="http://www.w3.org/2000/svg" width="30" height="30">
						<title id="avatarTitle">Author Avatar</title>
						<desc id="avatarDesc">A cartoon avatar of a smiling purple square on a blue background.</desc>
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
					<p class="byline fw-700 mb-0">작성자: Penny Pen</p>
				</div>

				<p class="dateline mb-0 fw-700">June 21, 2021</p>
			</div>

			<main>
				<section class="mb-7">
					<div class="row">
						<div class="col-md-8">
							<p class="lead mb-6 pb-3">
								Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis quidem est minima quam! Laborum odit quidem earum perferendis eius laudantium perspiciatis similique deleniti delectus suscipit, cum corrupti facere reprehenderit esse.
							</p>
						</div>
					</div>

					<div class="row row-cols-1 row-cols-md-3 text-body">
						<div class="col">
							<p>Animi aut, atque quibusdam similique distinctio enim iure, blanditiis rerum autem illum eum in. Dolorem quasi aspernatur nemo deserunt quo, libero dolore atque magni, ullam nihil corrupti et illo earum?</p>

							<p>Quos, ad? Et, iure. Officia fuga unde quibusdam nemo modi perspiciatis quisquam consectetur voluptates, dolore ab eaque voluptatem corporis placeat consequatur itaque qui asperiores. Consequuntur quas vitae animi est ea!</p>

							<p>Accusantium nemo labore corrupti laudantium! Quo reprehenderit ea perspiciatis temporibus! Illo sapiente harum fuga molestias temporibus iste animi. Velit, tenetur mollitia sit magni nulla quos veniam molestias consectetur aliquam eaque.</p>

							<aside class="border-start border-3 p-4 fw-700">
								<p>Quos, ad? Et, iure. Libero dolore atque magni.</p>
							</aside>

							<p>Voluptatem, omnis, placeat recusandae iste explicabo accusantium velit laboriosam voluptatum similique, fugit culpa enim! Suscipit labore odit porro assumenda, molestiae aperiam laboriosam explicabo nemo soluta facere sed libero magnam. Odio.</p>
						</div>

						<div class="col">
							<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis quidem est minima quam! Laborum odit quidem earum perferendis eius laudantium perspiciatis similique deleniti delectus suscipit, cum corrupti facere reprehenderit esse. Sed officia ipsum, soluta quibusdam enim quisquam ea atque nulla sunt temporibus, dolorum veniam dolor aspernatur quod. Praesentium vitae exercitationem quod, inventore eius quidem ea sit, nemo reprehenderit voluptatum officia.</p>

							<p>Animi aut, atque quibusdam similique distinctio enim iure, blanditiis rerum autem illum eum in. Dolorem quasi aspernatur nemo deserunt quo, libero dolore atque magni, ullam nihil corrupti et illo earum?
								Voluptatem, omnis, placeat recusandae iste explicabo accusantium velit laboriosam voluptatum similique, fugit culpa enim! Suscipit labore odit porro assumenda, molestiae aperiam laboriosam explicabo nemo soluta facere sed libero magnam</p>
						</div>

						<div class="col">
							<figure><img class="img-fluid" src="https://assets.codepen.io/t-1/freddy-g-lhy1lY3CyLI-unsplash.jpg" alt="a smiling person in a pink hoodie, standing in front of a bright pink lighted arcade basketball game. " />
								<figcaption class="small text-muted mt-2">Photo by Freddy G</figcaption>
							</figure>
						</div>
					</div>
				</section>

					

</body>
</html>
