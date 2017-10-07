package cn.sinjinsong.eshop.core.domain.entity.news;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NewsDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.id
     *
     * @mbggenerated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.title
     *
     * @mbggenerated
     */
    @NotNull
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.body
     *
     * @mbggenerated
     */
    @NotNull
    private String body;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column news.time
     *
     * @mbggenerated
     */
    private LocalDateTime time;
   
}