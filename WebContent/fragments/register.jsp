
<form action="Servlet_enregistrement" method="post">
<h2>Formulaire d'enregistrement</h2>
<br>
<input type="hidden" name="action" value="enregistrer">
<div class="row">
        <div class="col-xs-6 form-group">
            <label>Nom :</label>
            <input class="form-control" name="nom" type="text" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Prénom :</label>
            <input class="form-control" name="prenom" type="text" required/>
        </div>
        <div class="col-xs-12 form-group">
            <label>Adresse :</label>
            <input class="form-control" name="adresse" type="text" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Code Postal :</label>
            <input class="form-control" name="cp" type="number" maxlength="5" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Ville :</label>
            <input class="form-control" name="ville" type="text" />
        </div>
         <div class="col-xs-6 form-group">
            <label>Téléphone :</label>
            <input class="form-control" name="tel" type="number" maxlength="10" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>E-mail :</label>
            <input class="form-control" name="mail" type="email" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Mot de Passe :</label>
            <input class="form-control" name="pass" type="password" required/>
        </div>
        <div class="col-xs-6 form-group">
            <label>Confirmez le mot de passe :</label>
            <input class="form-control" name="pass_confirm" type="password" required/>
        </div>
          
    </div>

<button type="submit" class="btn btn-lg btn-default" id="btn_s_enregistrer" >Valider</button>
</form>
