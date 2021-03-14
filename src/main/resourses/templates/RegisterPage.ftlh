<#-- @ftlvariable name="registerForm" type="jb.gusarov.test.form.UserCredentials" -->
<#import "/spring.ftl" as spring>
<#import "commons.ftlh" as c>

<@c.page>
    <div class="registration form-box">
        <div class="header">Register</div>
        <div class="body">
            <form method="post" action="">
                <input type="hidden" name="action" value="register"/>
                <div class="field">
                    <div class="name">
                        <label for="name">Name</label>
                    </div>
                    <div class="value">
                        <input autofocus id="name" name="name" value="${registerForm.name!}"/>
                    </div>
                    <@c.error "registerForm.name"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="login">Surname</label>
                    </div>
                    <div class="value">
                        <input id="surname" name="surname" value="${registerForm.surname!}"/>
                    </div>
                    <@c.error "registerForm.surname"/>
                </div>
                <div class="field">
                    <div class="name">
                        <label for="password">Password</label>
                    </div>
                    <div class="value">
                        <input id="password" name="password" type="password" value=""/>
                    </div>
                    <@c.error "registerForm.password"/>
                </div>
                <div class="button-field">
                    <input type="submit" value="Register">
                </div>
            </form>
        </div>
    </div>
</@c.page>