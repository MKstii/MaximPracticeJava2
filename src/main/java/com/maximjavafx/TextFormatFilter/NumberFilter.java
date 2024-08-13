package com.maximjavafx.TextFormatFilter;

import javafx.scene.control.TextFormatter;

import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class NumberFilter implements UnaryOperator<TextFormatter.Change> {
    private final Pattern doublePatter = Pattern.compile("\\d*(\\.\\d*)?");
    private final Pattern intPatter = Pattern.compile("\\d*");
    private Pattern regPatter = doublePatter;

    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        String newText = change.getControlNewText();
        if (regPatter.matcher(newText).matches()) {
            return change;
        }
        return null;
    }

    @Override
    public <V> Function<V, TextFormatter.Change> compose(Function<? super V, ? extends TextFormatter.Change> before) {
        return UnaryOperator.super.compose(before);
    }

    @Override
    public <V> Function<TextFormatter.Change, V> andThen(Function<? super TextFormatter.Change, ? extends V> after) {
        return UnaryOperator.super.andThen(after);
    }

    public void setPatternIsInteger(){
        regPatter = intPatter;
    }

    public void setPatternIsDouble(){
        regPatter = doublePatter;
    }
}
