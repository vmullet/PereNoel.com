$(function(){
	
	showCurrentStepInfo('step-1');
	
	$("input[name=paiement]").on('click',function(){
		
		
		});
	
});




    function resetActive(event, percent, step) {
    	
    	if ((step=='step-3')&&($('input[name=paiement]:checked').length == 0)) {
    	    message('myModal','Erreur','Veuillez sélectionner un moyen de paiement');
    	}
    	else
    		{
        $(".progress-bar").css("width", percent + "%").attr("aria-valuenow", percent);
        $(".progress-completed").text(percent + "%");
        
        $("div").each(function () {
            if ($(this).hasClass("activestep")) {
                $(this).removeClass("activestep");
            }
        });

        if (event.target.className == "col-md-2") {
        	
            $(event.target).addClass("activestep");
        }
        else {
            $(event.target.parentNode).addClass("activestep");
        }
        
        hideSteps();
        showCurrentStepInfo(step);
    		}
    	
    }

    function hideSteps() {
        $("div").each(function () {
            if ($(this).hasClass("activeStepInfo")) {
                $(this).removeClass("activeStepInfo");
                $(this).addClass("hiddenStepInfo");
            }
        });
    }

    function showCurrentStepInfo(step) {        
        var id = "#" + step;
        $(id).addClass("activeStepInfo");
      
    }
    
    function verif_step(step)
    {
    	var num=1;
    	switch(step)
    	{
    	case "step-2":
    		num=1;
    		break;
    	case "step-3":
    		num=2;
    		break;
    	case "step-4":
    		num=3;
    		break;
    		default:
    			break;
    	}
    	var elem=document.getElementsByName("verif__"+num);
    	for (i=0;i<elem.length;i++)
    		{
    		if (elem[i].value=="")
    			return false;
    		}
    	return true;
    }
    
    
    
    