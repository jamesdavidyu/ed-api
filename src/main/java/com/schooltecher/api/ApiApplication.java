package com.schooltecher.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);
		System.out.println("Database connected successfully");
	}

	@GetMapping("/")
	public String hello() {
		return "<html>" +
					"<body>" +
						"<header>" +
							"<h1>" +
								"<a href='https://github.com/jamesdavidyu/ed-api' target='_blank'>ed-api.koyeb.app</a>: An API to exchange data for a lesson planning/teaching/analytics app" +
							"</h1>" +
							"<h2>Hello and welcome to this API written with Java's Spring Boot framework! Navigate by accessing the endpoints below (prefix is '/api/v1'):</h2>" +
						"</header>" +
						"<main>" +
							"<div>" +
								"<h3>Unauthenticated:</h3>" +
									"<ul>" +
										"<pre>" +
											"<li>'/register' - Creates new users. Send:</li>" +
												"<p style='text-indent:50px'>{</p>" +
													"<p style='text-indent:75px'>'username' : '[Your username here]',</p>" +
													"<p style='text-indent:75px'>'password' : '[Your password here]',</p>" +
													"<p style='text-indent:75px'>'role' : '[techer or student]',</p>" +
												"<p style='text-indent:50px'>}</p>" +
										"</pre>" +
										"<pre>" +
											"<li>'/login' - Authenticates user login data and returns an access token (please save to use with authenticated endpoints). Send:</li>" +
												"<p style='text-indent:50px'>{</p>" +
													"<p style='text-indent:75px'>'username' : '[Your username here]',</p>" +
													"<p style='text-indent:75px'>'password' : '[Your password here]',</p>" +
												"<p style='text-indent:50px'>}</p>" +
										"</pre>" +
									"</ul>" +
							"</div>" +
							"<div>" +
								"<h3>Authenticated (add '/auth' to the endpoint prefix; you will need to supply access token with the prefix 'Bearer ' to access these endpoints):</h3>" +
									"<h4>Lessons (add '/lessons' to the endpoint prefix) - Endpoints for users to create and get lessons:</h4>" +
									"<ul>" +
										"<pre>" +
											"<li>'/create' - Creates a new lesson and returns a lessonId (please save to use with other endpoints connected to lessons). Send:</li>" +
												"<p style='text-indent:50px'>{</p>" +
													"<p style='text-indent:75px'>'lesson' : '[Your lesson title here]',</p>" +
												"<p style='text-indent:50px'>}</p>" +
										"</pre>" +
										"<pre>" +
											"<li>'/get' - Gets all lessons created by a techer</li>" +
										"</pre>" +
									"</ul>" +
									"<h4>Questions (add '/questions' to the endpoint prefix) - Endpoints for users to create and get questions for students to answer in lessons:</h4>" +
									"<ul>" +
										"<pre>" +
											"<li>'/create/{lessonId}' - Creates a new question for a specific lesson and returns a questionId (please save to use with other endpoints connected to questions). Send:</li>" +
												"<p style='text-indent:50px'>{</p>" +
													"<p style='text-indent:75px'>'question' : '[Your question here]',</p>" +
												"<p style='text-indent:50px'>}</p>" +
										"</pre>" +
//										"<pre>" +
//											"<li>'/get' - Gets all lessons created by a techer</li>" +
//										"</pre>" +
									"</ul>" +
							"</div>" +
						"</main>" +
					"</body>" +
				"</html>";
	}
}
