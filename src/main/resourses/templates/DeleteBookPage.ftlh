<#-- @ftlvariable name="deleteBook" type="jb.gusarov.test.form.UserBookForm" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="form">
        <div class="header">Delete book from the library</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="deleteBook"/>
                <div class="field">
                    <div class="name">
                        <label for="cipher">Cipher</label>
                    </div>
                    <div class="value">
                        <input id="cipher" name="cipher" value="${deleteBook.cipher!}"/>
                    </div>
                    <@c.error "deleteBook.cipher"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Delete book">
                </div>
            </form>
        </div>
    </div>
</@c.page>