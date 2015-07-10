package cc.carlos.application.Http;

import android.os.Parcel;
import android.os.Parcelable;

import com.loopj.android.http.RequestParams;

/**
 * Created by carlos on 15/7/8.
 */
public class HttpRequestModel implements Parcelable {
    private Request_type request_type;
    private RequestParams requestParams;
    private String url;
    private String broadcaseKey;

    public HttpRequestModel() {

    }


    public Request_type getRequest_type() {
        return request_type;
    }

    public void setRequest_type(Request_type request_type) {
        this.request_type = request_type;
    }

    public RequestParams getRequestParams() {
        return requestParams;
    }

    public void setRequestParams(RequestParams requestParams) {
        this.requestParams = requestParams;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBroadcaseKey() {
        return broadcaseKey;
    }

    public void setBroadcaseKey(String broadcaseKey) {
        this.broadcaseKey = broadcaseKey;
    }


    public enum Request_type {
        JSON(1), UPLOAD(2);
        private int nCode;

        Request_type(int _nCode) {
            this.nCode = _nCode;
        }

        @Override
        public String toString() {
            return String.valueOf(this.nCode);
        }
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(request_type);
        dest.writeString(requestParams.toString());
        dest.writeString(url);
        dest.writeString(broadcaseKey);
    }

    private HttpRequestModel(Parcel in) {
        setRequest_type((Request_type) in.readSerializable());
        setRequestParams(new RequestParams(in.readString()));
        setUrl(in.readString());
        setBroadcaseKey(in.readString());
    }

    public static final Parcelable.Creator<HttpRequestModel> CREATOR = new Parcelable.Creator<HttpRequestModel>() {

        public HttpRequestModel createFromParcel(Parcel in) {
            return new HttpRequestModel(in);
        }

        @Override
        public HttpRequestModel[] newArray(int size) {
            return new HttpRequestModel[size];
        }

    };
}
