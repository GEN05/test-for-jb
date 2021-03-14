<#-- @ftlvariable name="changeCipher" type="jb.gusarov.test.form.ChangeCipherForm" -->

<#import "commons.ftlh" as c>

<@c.page>
    <div class="form">
        <div class="header">Change cipher</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="changeCipher"/>
                <div class="field">
                    <div class="name">
                        <label for="cipher">Cipher</label>
                    </div>
                    <div class="value">
                        <input autofocus id="cipher" name="cipher" value="${changeCipher.cipher!}"/>
                    </div>
                    <@c.error "changeCipher.cipher"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="newCipher">New cipher</label>
                    </div>
                    <div class="value">
                        <input autofocus id="newCipher" name="newCipher" value="${changeCipher.cipher!}"/>
                    </div>
                    <@c.error "changeCipher.cipher"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Change cipher">
                </div>
            </form>
        </div>
    </div>
</@c.page>