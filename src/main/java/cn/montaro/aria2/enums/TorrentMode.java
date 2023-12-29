package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TorrentMode implements EnumValue<String> {

    SINGLE("single"),
    MULTI("multi");
    private final String value;
}
