$(function(){
	
	System.out.println("menu are "+menu);
	//solving the active menu problem
	switch (menu) {

	case 'About':
		
		$('#about').addClass('active');
		break;

	case 'Contact':
		$('#contact').addClass('active');
		break;
		
	case 'View Products':
		$('#listproducts').addClass('active');
		break;
		
		
	default:
		if(menu=="Home") break;
		$('#listproducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
});