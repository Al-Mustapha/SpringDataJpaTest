package com.example.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;

public class ApplicationUserDetails implements UserDetails {
    private final Collection<? extends GrantedAuthority> getAuthorities;
    private final String getPassword;
    private final String getUsername;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialNonExpired;

    private final boolean isEnabled;

    public ApplicationUserDetails(Collection<? extends GrantedAuthority> getAuthorities,
                                  String getPassword, String getUsername,
                                  boolean isAccountNonExpired, boolean isAccountNonLocked,
                                  boolean isCredentialNonExpired, boolean isEnabled) {
        this.getAuthorities = getAuthorities;
        this.getPassword = getPassword;
        this.getUsername = getUsername;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialNonExpired = isCredentialNonExpired;
        this.isEnabled = isEnabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getAuthorities;
    }

    @Override
    public String getPassword() {
        return getPassword;
    }

    @Override
    public String getUsername() {
        return getUsername;
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
