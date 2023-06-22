package servlet;

import java.util.ArrayList;

public class Carrello {
	private ArrayList<Prodotto> carrello = new ArrayList<>();
	
	public ArrayList<Prodotto> getCarrello() {
		return carrello;
	}

	public void setCarrello(ArrayList<Prodotto> carrello) {
		this.carrello = carrello;
	}

	public void add(Prodotto p) {
		carrello.add(p);
	}
	
	public void empty(Prodotto p) {
		carrello.clear();
	}
	
	public static String toJavascriptArray(ArrayList<Prodotto> list){
	    StringBuffer sb = new StringBuffer();
	   
	    for(int i=0; i<list.size(); i++){
	        sb.append("{img: \"").append(list.get(i).getImg()).append("\"");
	        sb.append("nome: \"").append(list.get(i).getNome()).append("\"");
	        sb.append("prezzo: \"").append(list.get(i).getPrezzo()).append("\"}");
	        if(i+1 < list.size()){
	            sb.append(",");
	        }
	    }
	    sb.append("]");
	    return sb.toString();
 	}
	
}
