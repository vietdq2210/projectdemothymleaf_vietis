package com.vietis.projectdemo_vietis.utils;

import com.vietis.projectdemo_vietis.security.CustomUser;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class WebUtils {

    public static String toString(CustomUser user) {
        StringBuilder sb = new StringBuilder();

        sb.append("UserName: ").append(user.getUsername());

        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        if (authorities != null && !authorities.isEmpty()) {
            sb.append(" (");
            boolean first = true;
            for (GrantedAuthority a : authorities) {
                if (first) {
                    sb.append(a.getAuthority());
                    first = false;
                } else {
                    sb.append(", ").append(a.getAuthority());
                }
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
