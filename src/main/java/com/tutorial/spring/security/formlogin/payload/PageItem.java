package com.tutorial.spring.security.formlogin.payload;

import com.tutorial.spring.security.formlogin.Enum.PageItemType;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageItem {

    private PageItemType pageItemType;

    private int index;

    private boolean active;

}