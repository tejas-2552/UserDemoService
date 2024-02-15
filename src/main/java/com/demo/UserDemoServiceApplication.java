package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;

import com.demo.model.UserMst;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class UserDemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserDemoServiceApplication.class, args);
	}

	public static int[] twoSum(int[] arr, int target) {

		int i = 0;
		int j = 0;
		while (i < arr.length) {
			if (j < arr.length && arr[i] + arr[j] == target) {
				int[] returnArr = { i, j };
				return returnArr;
			} else if (j < arr.length) {
				j++;
			} else {
				i++;
				j = i + 1;
			}

		}
		return null;
	}

}
