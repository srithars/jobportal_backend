package klu.modal;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtManager {
	public final String SEC_KEY = "ASDFGHJKLQWERTYUIOPZXCVBNM098762345612abdgceftyuobght";
	public final SecretKey KEY = Keys.hmacShaKeyFor(SEC_KEY.getBytes());
	
	//Generate JWT
	public String generateJWT(String username)
	{
		Map<String, String> data = new HashMap<String, String>();
		data.put("username", username);
		
		return Jwts.builder()
				.setClaims(data)
				.setIssuedAt(new Date())
				.setExpiration(new Date(new Date().getTime() + 86400000))
				.signWith(KEY)
				.compact();
	}
	
	//Validate JWT
	public String validateJWT(String token)
	{
		try
		{
			Claims claims = Jwts.parserBuilder()
							.setSigningKey(KEY)
							.build()
							.parseClaimsJws(token)
							.getBody();
			
			Date expiry = claims.getExpiration();
			if(expiry == null || expiry.before(new Date()))
				throw new Exception("401");
			
			return claims.get("username", String.class);
			
		}catch(Exception e)
		{
			return e.getMessage();
		}
	}
}
