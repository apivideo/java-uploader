package org.yitzi.video.api.apivideo.infrastructure.unirest.account;

import org.json.JSONException;
import org.json.JSONObject;
import org.yitzi.video.api.apivideo.domain.account.Account;
import org.yitzi.video.api.apivideo.infrastructure.unirest.serializer.JsonDeserializer;

public class AccountDeserializer implements JsonDeserializer<Account> {
    public Account deserialize(JSONObject data) throws JSONException {
        JSONObject jsonQuota = data.getJSONObject("quota");

        return new Account(
                new Account.Quota(
                        getIntOrNull(jsonQuota, "quotaRemaining"),
                        getIntOrNull(jsonQuota, "quotaUsed"),
                        getIntOrNull(jsonQuota, "quotaTotal")
                ),
                convertJsonArrayToStringList(data.getJSONArray("features"))
        );
    }

    private Integer getIntOrNull(JSONObject data, String key) {
        return data.has(key) && !data.isNull(key) ? data.getInt(key) : null;
    }

}
