package org.mql.java.models;

import java.io.Serializable;

public class Produits implements Serializable {

	int ref;
	String design;
	int pu;
	int qs;

	public Produits() {
		this(3, "java", 45, 56);
	}

	public Produits(int ref, String design, int pu, int qs) {
		super();
		this.ref = ref;
		this.design = design;
		this.pu = pu;
		this.qs = qs;
	}

	@Override
	public String toString() {
		return "Produits [ref=" + ref + ", design=" + design + ", pu=" + pu + ", qs=" + qs + "]";
	}

}
