package cn.hqweay.blog.config;

/**
 * @description: TODO
 * Created by hqweay on 19-3-30 上午11:14
 */

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * Swagger配置文件。
 * [Springfox官方集成文档](http://springfox.github.io/springfox/docs/current/)
 * [Swagger注解官方文档](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)
 * <p>
 * 配置注意事项：
 * 1. swagger及swagger-ui的添加，注意版本
 * 2. 该config文件的注解添加，@Configuration与@EnableSwagger2为必须添加
 * 3. 配置servlet-mapping为"/"，因为会生成静态文件，因此需要注意路径穿透
 * <p>
 * <p>
 * 访问 : http://localhost:8082/swagger-ui.html
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

  /**
   * 根据配置读取是否开启swagger文档，针对测试与生产环境采用不同的配置
   */
  @Value("${swagger.enable}")
  private boolean isSwaggerEnable;

  @Bean
  public Docket createRestApi() {

    // 添加 Authorization 消息头
    ParameterBuilder ticketPar = new ParameterBuilder();
    List<Parameter> pars = new ArrayList<Parameter>();
    ticketPar.name("Authorization").description("登录校验")//name表示名称，description表示描述
            .modelRef(new ModelRef("string")).parameterType("header")
            .required(false).defaultValue("").build();//required表示是否必填，defaultvalue表示默认值
    pars.add(ticketPar.build());//添加完此处一定要把下边的带***的也加上否则不生效
    // end

    return new Docket(DocumentationType.SWAGGER_2)
//            .groupName("hqweay")
            .protocols(Sets.newHashSet("http")) //协议，http或https
            .enable(isSwaggerEnable)
            .apiInfo(apiInfo()).select()
            // 对所有该包下的Api进行监控，如果想要监控所有的话可以改成any()
            .apis(RequestHandlerSelectors.basePackage("cn.hqweay.blog"))
            // 对所有路径进行扫描
            .paths(PathSelectors.any())
            .build()
            .globalOperationParameters(pars);//************把消息头添加;
  }

  /**
   * @return 生成文档说明信息
   */
  private ApiInfo apiInfo() {
    return new ApiInfoBuilder()
            .title("Blog API 文档")
            .description("用于测试 RESTful API")
//            .termsOfServiceUrl("http://hqweay.cn")
            .version("1.0").build();
  }
}
