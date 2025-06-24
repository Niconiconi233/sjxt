package com.ruoyi.esearch.domain;

import lombok.Data;
import org.dromara.easyes.annotation.HighLight;
import org.dromara.easyes.annotation.IndexField;
import org.dromara.easyes.annotation.rely.FieldType;

import java.util.Date;

@Data
public class Attachment {
    @IndexField(fieldType = FieldType.DATE)
    private Date date;

    @IndexField(fieldType = FieldType.KEYWORD)
    private String content_type;

    @IndexField(fieldType = FieldType.KEYWORD)
    private String language;

    @IndexField(fieldType = FieldType.TEXT)
    private String title;

    @HighLight(preTag = "<em style='color:red'>", postTag = "</em>")
    @IndexField(fieldType = FieldType.TEXT)
    private String content;

    @IndexField(fieldType = FieldType.LONG)
    private Long content_length;
}
