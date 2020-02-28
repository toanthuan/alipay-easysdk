package com.alipay.easysdk.base.oauth;

import com.alipay.easysdk.TestAccount;
import com.alipay.easysdk.base.oauth.models.AlipaySystemOauthTokenResponse;
import com.alipay.easysdk.factory.Factory;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class ClientTest {
    @Before
    public void setUp() {
        Factory.setOptions(TestAccount.Mini.CONFIG);
    }

    @Test
    public void testGetToken() throws Exception {
        AlipaySystemOauthTokenResponse response = Factory.Base.OAuth().getToken("ee4b3c871f7c4f30a82251908458VB64");

        assertThat(response.code, is("40002"));
        assertThat(response.msg, is("Invalid Arguments"));
        assertThat(response.subCode, is("isv.code-invalid"));
        assertThat(response.subMsg, is("授权码code无效"));
        assertThat(response.httpBody, not(nullValue()));
    }

    @Test
    public void testRefreshToken() throws Exception {
        AlipaySystemOauthTokenResponse response = Factory.Base.OAuth().refreshToken("1234567890");

        assertThat(response.code, is("40002"));
        assertThat(response.msg, is("Invalid Arguments"));
        assertThat(response.subCode, is("isv.refresh-token-invalid"));
        assertThat(response.subMsg, is("刷新令牌refresh_token无效"));
        assertThat(response.httpBody, not(nullValue()));
    }
}