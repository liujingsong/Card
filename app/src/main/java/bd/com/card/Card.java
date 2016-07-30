package bd.com.card;

/**
 * Description : <Content><br>
 * CreateTime : 2016/7/30 17:29
 *
 * @author KevinLiu
 * @version <v1.0>
 * @Editor : KevinLiu
 * @ModifyTime : 2016/7/30 17:29
 * @ModifyDescription : <Content>
 */
public class Card {

    String word;

    int code;

    String imgUrl;

    public Card(int code, String word, String imgUrl) {
        this.code = code;
        this.word = word;
        this.imgUrl = imgUrl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
