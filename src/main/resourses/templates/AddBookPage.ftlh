<#-- @ftlvariable name="bookForm" type="jb.gusarov.test.form.BookForm" -->

<#import "commons.ftlh" as c>

<@c.page>
    <div class="form">
        <div class="header">Add book to the library</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="addBook"/>
                <div class="field">
                    <div class="name">
                        <label for="cipher">Cipher</label>
                    </div>
                    <div class="value">
                        <input id="cipher" name="cipher" value="${bookForm.cipher!}"/>
                    </div>
                    <@c.error "bookForm.cipher"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="title">Title</label>
                    </div>
                    <div class="value">
                        <input autofocus id="title" name="title" value="${bookForm.title!}"/>
                    </div>
                    <@c.error "bookForm.title"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="text">Author</label>
                    </div>
                    <div class="value">
                        <input id="author" name="author" value="${bookForm.author!}"/>
                    </div>
                    <@c.error "bookForm.author"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Add book">
                </div>
            </form>
        </div>
    </div>
</@c.page>