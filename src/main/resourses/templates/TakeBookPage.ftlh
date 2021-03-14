<#-- @ftlvariable name="takeBook" type="jb.gusarov.test.form.UserBookForm" -->

<#import "commons.ftlh" as c>

<@c.page>
    <div class="form">
        <div class="header">Take book</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="takeBook"/>
                <div class="field">
                    <div class="name">
                        <label for="cipher">Cipher</label>
                    </div>
                    <div class="value">
                        <input autofocus id="cipher" name="cipher" value="${takeBook.cipher!}"/>
                    </div>
                    <@c.error "takeBook.cipher"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Write">
                </div>
            </form>
        </div>
    </div>
</@c.page>