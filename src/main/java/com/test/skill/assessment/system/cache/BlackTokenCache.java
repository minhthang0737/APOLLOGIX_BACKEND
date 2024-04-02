package com.test.skill.assessment.system.cache;

import java.util.HashSet;
import java.util.Set;

public class BlackTokenCache {
	private static Set<String> tokens;
	
	public static Set<String> addBlackToken(String token) {
		if (tokens == null) tokens = new HashSet<>();
		tokens.add(token);
		return tokens;
	}
	
	
}
