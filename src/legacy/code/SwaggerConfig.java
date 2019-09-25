package legacy.code;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

// Main source of inspiration here:
// http://www.baeldung.com/swagger-2-documentation-for-spring-rest-api
// Note: for some reason, we still need to add WebMvcConfigurerAdapter
// even though the tutorial says it's not needed if you're using Spring Boot.
// Also note that I had to put in content-negotiation-manager in servlet-context.xml
// for this to finally work. I don't know why. I just did a line-by-line
// comparison with Sasuke's setup.

@Configuration
@EnableSwagger2
@EnableWebMvc
public class SwaggerConfig extends WebMvcConfigurerAdapter {
//public class SwaggerConfig {

//	private static Predicate<String> JIRAIYA_PATH = regex("/sdk.*");
//	private static Predicate<String> TSUNADE_PATH = regex("/websdk.*");

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

/*
	@Bean
	public Docket all() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("all").select().apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.any()).build().securitySchemes(newArrayList(apiKey()))
				.securityContexts(newArrayList(securityContext())).protocols(newHashSet("http", "https"));
	}
*/
/*	
	@Bean
	public Docket jiraiya() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("jiraiya").select().apis(RequestHandlerSelectors.any())
				.paths(JIRAIYA_PATH).build().securityContexts(newArrayList(securityContext()))
				.protocols(newHashSet("http", "https"));
	}

	@Bean
	public Docket tsunade() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("tsunade").apiInfo(apiInfo()).host("api.gigato.co:80")
				.select().apis(RequestHandlerSelectors.any()).paths(TSUNADE_PATH).build()
				.pathProvider(new BasePathAwareRelativePathProvider("/websdk/v1"))
				.securitySchemes(newArrayList(apiKey())).securityContexts(newArrayList(securityContext()))
				.protocols(newHashSet("http", "https")).enableUrlTemplating(true);
	}
*/

//	@Bean
//	SecurityConfiguration security() {
//		return new SecurityConfiguration("wedsdk-v1-id", "wedsdk-v1-secret", "wedsdk-v1-realm", "wedsdk-v1--app",
//				apiKey().getKeyname(), ApiKeyVehicle.HEADER, apiKey().getName(),
//				"," /* scope separator */);
//	}
	
	/*
	private ApiKey apiKey() {
		return new ApiKey("Authorization", "", "header");
	}

	private SecurityContext securityContext() {
		return SecurityContext.builder().securityReferences(defaultAuth()).forPaths(regex("/anyPath.*")).build();
	}

	List<SecurityReference> defaultAuth() {
		AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		authorizationScopes[0] = authorizationScope;
		return newArrayList(new SecurityReference("Authorization", authorizationScopes));
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("Mavin REST API Documentation")
				.description("Mavin REST API allows you to create wallets, track events and request redemptions.")
				.termsOfServiceUrl("https://sdk.mavin.co").license("Apache License Version 2.0").version("1.0").build();
	}

	class BasePathAwareRelativePathProvider extends AbstractPathProvider {
		private String basePath;

		public BasePathAwareRelativePathProvider(String basePath) {
			this.basePath = basePath;
		}

		@Override
		protected String applicationPath() {
			return basePath;
		}

		@Override
		protected String getDocumentationPath() {
			return "/";
		}

		@Override
		public String getOperationPath(String operationPath) {
			UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/");
			return Paths.removeAdjacentForwardSlashes(
					uriComponentsBuilder.path(operationPath.replaceFirst(basePath, "")).build().toString());
		}
	}
*/

}