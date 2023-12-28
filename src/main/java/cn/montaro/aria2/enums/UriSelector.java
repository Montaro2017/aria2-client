package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum UriSelector {
    INORDER("inorder"),
    FEEDBACK("feedback"),
    ADAPTIVE("adaptive");
    private final String value;
}
