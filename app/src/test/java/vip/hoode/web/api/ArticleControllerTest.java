package vip.hoode.web.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.restdocs.RestDocsProperties;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vip.hoode.object.ConfirmMessage;
import vip.hoode.service.ArticleService;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author mitu2
 */
@WebMvcTest(
        controllers = ArticleController.class,
        excludeAutoConfiguration = {SecurityAutoConfiguration.class},
        properties = "spring.config.import=classpath:application-apidoc.yml"
)
@AutoConfigureRestDocs
class ArticleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Value("${hoode.api-version}")
    String apiVersion;

    @Autowired
    RestDocsProperties restDocsProperties;

    @Test
    void testDeleteById() throws Exception {
        System.out.println(restDocsProperties.getUriHost());
        Mockito.when(articleService.invalidById(1L)).thenReturn(ConfirmMessage.success());

        mockMvc.perform(
                        delete("/{apiVersion}/article/{id}", apiVersion, 1L)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(
                        document(
                                "article/deleteById",
                                responseFields(
                                        fieldWithPath("confirmed").description("是否确认").optional()
                                )
                        )
                );
    }

}