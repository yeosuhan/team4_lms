<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<%@ include file="/WEB-INF/views/fragment/head.jsp" %>

<%@ include file="/WEB-INF/views/fragment/nav.jsp" %>
	<title>board</title>
	<style>
	@import url("https://fonts.googleapis.com/css2?family=Noticia+Text&display=swap");
html {
	background: linear-gradient(
			to bottom right,
			transparent 48%,
			#efefef 48%,
			#efefef 52%,
			transparent 52%
		),
		linear-gradient(
			to bottom left,
			transparent 48%,
			#efefef 48%,
			#efefef 52%,
			transparent 52%
		);
	background-size: 0.25rem 0.25rem;
}
body {
	width: 100%;
	max-width: 700px;
	font-family: sans-serif;
	padding-bottom: 1vw;
	margin: 0 auto;
	box-shadow: 0 0 300px black;
}

h1 {
	column-span: all;
	background: black;
	color: white;
	font-size: 10vw;
	margin: 0;
	padding-left: 1rem;
}

.article-meta {
	column-span: all;
	padding-right: 1rem;
	padding-bottom: 1rem;
}
.article-meta * {
	display: inline-block;
	vertical-align: middle;
}
.article-meta svg {
	float: right;
	margin-top: -3rem;
	filter: saturate(0) contrast(5);
	border-radius: 50%;
	border: 0.5rem solid black;
	box-shadow: inset 0 0 0 2px black;
	box-sizing: border-box;
	transition: 0.75s;
}
.article-meta svg:hover {
	filter: saturate(1) contrast(1);
}
.article-meta p {
	margin: 0.25rem 0;
}
.article-meta span {
	text-decoration: underline;
	cursor: pointer;
}

h2 {
	background: black;
	color: white;
	font-size: 2rem;
	column-span: all;
	padding: 1rem;
	width: fit-content;
	max-width: 75%;
}

figure {
	width: max(50%, 350px);
	float: right;
	padding: 0 1rem;
	margin: 0;
}
img {
	width: 100%;
	filter: grayscale(1) contrast(0.75);
	transition: 0.75s;
}
img:hover {
	filter: grayscale(0) contrast(1);
}
figcaption {
	font-size: 0.75rem;
}

p {
	line-height: 1.5rem;
	padding: 0 1.5rem;
	font-family: "Noticia Text", serif;
}
	
	</style>
	<h1 class="headline">게시글 제목</h1>
<div class="article-meta">
	<svg id="author-avatar" viewBox="0 0 36 36" fill="none" xmlns="http://www.w3.org/2000/svg" width="80" height="80">
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
	<p class="byline">작성자: Penny Pen</p>
	<p class="dateline">June 21, 2021</p>
	<p class="article-tags">
		<span class="tag">culture</span> <span class="tag">games</span> <span class="tag featured">featured</span>
	</p>
</div>

<h2 class="subhead">The next generation of arcade gamers top the leaderboard</h2>

<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis quidem est minima quam! Laborum odit quidem earum perferendis eius laudantium perspiciatis similique deleniti delectus suscipit, cum corrupti facere reprehenderit esse.</p>
<p>Animi aut, atque quibusdam similique distinctio enim iure, blanditiis rerum autem illum eum in. Dolorem quasi aspernatur nemo deserunt quo, libero dolore atque magni, ullam nihil corrupti et illo earum?</p>
<p>Quos, ad? Et, iure. Officia fuga unde quibusdam nemo modi perspiciatis quisquam consectetur voluptates, dolore ab eaque voluptatem corporis placeat consequatur itaque qui asperiores. Consequuntur quas vitae animi est ea!</p>
<p>Accusantium nemo labore corrupti laudantium! Quo reprehenderit ea perspiciatis temporibus! Illo sapiente harum fuga molestias temporibus iste animi. Velit, tenetur mollitia sit magni nulla quos veniam molestias consectetur aliquam eaque.</p>
<p>Voluptatem, omnis, placeat recusandae iste explicabo accusantium velit laboriosam voluptatum similique, fugit culpa enim! Suscipit labore odit porro assumenda, molestiae aperiam laboriosam explicabo nemo soluta facere sed libero magnam. Odio.</p>

<aside>
	<p>Quos, ad? Et, iure. Libero dolore atque magni.</p>
</aside>

<figure><img src="https://assets.codepen.io/t-1/freddy-g-lhy1lY3CyLI-unsplash.jpg" alt="a smiling person in a pink hoodie, standing in front of a bright pink lighted arcade basketball game. " />
	<figcaption>Photo by Freddy G</figcaption>
</figure>
<!-- full size image: https://images.unsplash.com/flagged/photo-1556339911-7ef846e7db43-->

<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Facilis quidem est minima quam! Laborum odit quidem earum perferendis eius laudantium perspiciatis similique deleniti delectus suscipit, cum corrupti facere reprehenderit esse. Sed officia ipsum, soluta quibusdam enim quisquam ea atque nulla sunt temporibus, dolorum veniam dolor aspernatur quod. Praesentium vitae exercitationem quod, inventore eius quidem ea sit, nemo reprehenderit voluptatum officia.</p>
<p>Animi aut, atque quibusdam similique distinctio enim iure, blanditiis rerum autem illum eum in. Dolorem quasi aspernatur nemo deserunt quo, libero dolore atque magni, ullam nihil corrupti et illo earum?</p>
<p>Voluptatem, omnis, placeat recusandae iste explicabo accusantium velit laboriosam voluptatum similique, fugit culpa enim! Suscipit labore odit porro assumenda, molestiae aperiam laboriosam explicabo nemo soluta facere sed libero magnam. Odio.</p>
<p>Quae, cumque blanditiis? Nisi rem ullam, ducimus qui praesentium, temporibus mollitia ex voluptatibus aut accusamus reprehenderit soluta eius expedita dicta adipisci debitis repudiandae quibusdam laborum possimus cupiditate quidem doloribus quas.</p>
<p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Harum vitae debitis reiciendis nam molestias, iure, recusandae magnam cupiditate ut dolore aliquam nesciunt ipsum sit illum nihil quibusdam mollitia veritatis maiores.</p>

<%@ include file="/WEB-INF/views/fragment/footer.jsp" %>