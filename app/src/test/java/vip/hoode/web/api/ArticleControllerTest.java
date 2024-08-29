package vip.hoode.web.api;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import vip.hoode.object.ConfirmMessage;
import vip.hoode.object.view.ArticleView;
import vip.hoode.security.SecurityConfiguration;
import vip.hoode.service.ArticleService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
@Import(SecurityConfiguration.class)
class ArticleControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Value("${hoode.api-version}")
    String apiVersion;

    @Test
    void deleteById() throws Exception {
        Mockito.when(articleService.invalidById(any()))
                .thenReturn(ConfirmMessage.success());

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
                                "article/{method-name}",
                                responseFields(
                                        fieldWithPath("confirmed").description("是否确认").optional()
                                )
                        )
                );
    }

    @Test
    void getById() throws Exception {
        Mockito.when(articleService.getById(anyLong()))
                .thenReturn(mock(ArticleView.class));

        mockMvc.perform(
                        get("/{apiVersion}/article/{id}", apiVersion, 1L)
                                .accept(MediaType.APPLICATION_JSON)
                )
                .andExpectAll(
                        status().isOk(),
                        content().contentType(MediaType.APPLICATION_JSON)
                )
                .andDo(
                        document(
                                "article/{method-name}",
                                responseFields(
                                        fieldWithPath("name").description("文章名称").optional(),
                                        fieldWithPath("meta").description("元信息").optional(),
                                        fieldWithPath("statistic").description("统计信息").optional(),
                                        fieldWithPath("contentText").description("内容(无标签)").optional(),
                                        fieldWithPath("content").description("内容").optional(),
                                        fieldWithPath("tags").description("标签"),
                                        fieldWithPath("categories").description("分类"),
                                        fieldWithPath("createdUser").description("创建者")
                                )
                        )
                );
    }


}