package cn.montaro.aria2.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ProxyMethod {

    GET("get"),
    TUNNEL("tunnel");
    private final String value;
}
