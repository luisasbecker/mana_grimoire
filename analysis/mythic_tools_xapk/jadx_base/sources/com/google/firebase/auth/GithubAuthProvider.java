package com.google.firebase.auth;

/* JADX INFO: compiled from: com.google.firebase:firebase-auth@@24.0.1 */
/* JADX INFO: loaded from: classes5.dex */
public class GithubAuthProvider {
    public static final String GITHUB_SIGN_IN_METHOD = "github.com";
    public static final String PROVIDER_ID = "github.com";

    private GithubAuthProvider() {
    }

    public static AuthCredential getCredential(String str) {
        return new GithubAuthCredential(str);
    }
}
