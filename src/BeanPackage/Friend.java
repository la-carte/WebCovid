package BeanPackage;

import java.util.HashSet;
import java.util.Set;

public class Friend {
	private Set<UserBean> listeAmi = new HashSet<>();
	boolean[] isFriend = new boolean[listeAmi.size()];
	

public Friend() {
	
}



public boolean[] getIsFriend() {
	return isFriend;
}



public void setIsFriend(boolean[] isFriend) {
	this.isFriend = isFriend;
}



public Set<UserBean> getListeAmi() {
	return listeAmi;
}

public void setListeAmi(Set<UserBean> lisetAmi) {
	this.listeAmi = lisetAmi;
}



}