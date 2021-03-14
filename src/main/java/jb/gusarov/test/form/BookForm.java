package jb.gusarov.test.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class BookForm {
    @NotNull
    @NotEmpty
    @Size(min = 2, max = 60)
    private String title;

    @NotNull
    @NotEmpty
    @Size(min = 2, max = 60)
    private String author;

    @NotNull
    private long cipher;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getCipher() {
        return cipher;
    }

    public void setCipher(long cipher) {
        this.cipher = cipher;
    }
}