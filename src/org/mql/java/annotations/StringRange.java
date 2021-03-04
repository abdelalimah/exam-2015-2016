package org.mql.java.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface StringRange {

	char min();

	String max();

}
