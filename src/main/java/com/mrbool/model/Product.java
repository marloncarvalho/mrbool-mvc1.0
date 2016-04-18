package com.mrbool.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.FormParam;

import com.mrbool.exception.ObjectNotFoundException;

public class Product {

	@FormParam("code")
	@NotNull
	private String code;

	@FormParam("name")
	@NotNull
	private String name;

	@FormParam("price")
	@NotNull
	@Min(0)
	private Double price;

	@FormParam("description")
	private String description;

	private static List<Product> list = new ArrayList<Product>();

	static {
		list.add(new Product("B1", "Weiss", 6.50, "Weiss Beer"));
		list.add(new Product("B2", "Pilsen", 4.50, "Pilsen Beer"));
		list.add(new Product("B3", "Stout", 16.50, "Stout Beer"));
		list.add(new Product("B4", "IPA", 12.50, "IPA Beer"));
	}

	public Product() {
	}

	public Product(String code, String name, Double price, String description) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public static List<Product> list() {
		return list;
	}

	public static Product get(String code) {
		Product result = null;

		for (Product product : list) {
			if (product.code.equals(code)) {
				result = product;
				break;
			}
		}

		if (result == null) {
			throw new ObjectNotFoundException();
		}

		return result;
	}

	public static void edit(Product product) {
		Product e = get(product.code);
		e.code = product.code;
		e.description = product.description;
		e.name = product.name;
		e.price = product.price;
	}

	public static void add(Product product) {
		list.add(product);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
