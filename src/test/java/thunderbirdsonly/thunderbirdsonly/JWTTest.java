package thunderbirdsonly.thunderbirdsonly;

import org.junit.jupiter.api.Test;
import thunderbirdsonly.thunderbirdsonly.Utility.JwtUtils;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


class JwtUtilsTest {

    @Test
    void testGenerateAndDecodeToken() {
        // Create sample claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", "john.doe");
        claims.put("role", "admin");

        // Generate a JWT token
        String token = JwtUtils.generateToken(claims);
        assertNotNull(token, "Generated token should not be null");

        // Decode the JWT token
        Claims decodedClaims = JwtUtils.decodeToken(token);
        assertNotNull(decodedClaims, "Decoded claims should not be null");

        // Validate the claims
        assertEquals("john.doe", decodedClaims.get("username"), "Username should match");
        assertEquals("admin", decodedClaims.get("role"), "Role should match");

        // Validate expiration time
        assertTrue(decodedClaims.getExpiration().after(new Date()), "Token should not be expired");
    }

    @Test
    void testDecodeInvalidToken() {
        String invalidToken = "invalid.jwt.token";
        // Decode an invalid JWT token
        Exception exception = assertThrows(Exception.class, () -> JwtUtils.decodeToken(invalidToken));
        assertNotNull(exception, "Exception should be thrown for invalid token");
    }
}

