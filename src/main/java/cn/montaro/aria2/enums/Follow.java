package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Follow implements EnumValue<String> {

    TRUE("true"),
    FALSE("false"),
    MEM("mem");
    private final String value;
}
