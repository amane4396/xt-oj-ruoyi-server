package com.ruoyi.common.core;

public class Question {
    /**
     * 要编译和执行的代码
     */
    private String code;

    /**
     * 执行时标准输入要输入的内容
     *    我们实际上没用
     */
    private String stdin;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStdin() {
        return stdin;
    }

    public void setStdin(String stdin) {
        this.stdin = stdin;
    }
}
