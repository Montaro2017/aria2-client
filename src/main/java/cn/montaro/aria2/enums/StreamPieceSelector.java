package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StreamPieceSelector {
    DEFAULT("default"),
    INORDER("inorder"),
    RANDOM("random"),
    GEOM("geom");
    private final String value;
}
