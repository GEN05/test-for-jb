<#-- @ftlvariable name="enterForm" type="jb.gusarov.test.form.UserCredentials" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="enter form-box">
        <div class="header">Enter</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="enter"/>
                <div class="field">
                    <div class="name">
                        <label for="name">Name</label>
                    </div>
                    <div class="value">
                        <input autofocus id="name" name="name" value="${enterForm.name!}"/>
                    </div>
                    <@c.error "enterForm.name"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="surname">Surname</label>
                    </div>
                    <div class="value">
                        <input id="surname" name="surname" value="${enterForm.surname!}"/>
                    </div>
                    <@c.error "enterForm.surname"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="password">Password</label>
                    </div>
                    <div class="value">
                        <input id="password" name="password" type="password" value=""/>
                    </div>
                    <@c.error "enterForm.password"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Enter">
                </div>
            </form>
        </div>
    </div>
</@c.page>