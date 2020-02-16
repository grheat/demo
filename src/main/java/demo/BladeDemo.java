package demo;

import com.blade.Blade;

public class BladeDemo {
    public static void main(String[] args) {
        Blade.of().get("/", ctx -> ctx.text("Hello Blade")).start();
    }
}
