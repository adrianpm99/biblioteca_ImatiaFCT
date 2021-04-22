package com.imatia.bookmanager.view.menus;

	import com.imatia.bookmanager.view.inputs.InputUserData;
	import com.imatia.bookmanager.view.ui.EditBookUi;
import com.imatia.bookmanager.view.ui.LendingsUi;
import com.imatia.bookmanager.view.ui.SearchesUi;




	public class LendingDetailsMenu {
		public static void showLendingDetailsOptions() {

			int option;

			do {
				option = Integer.parseInt(InputUserData.checkUserInput("option"));

				switch (option)
				{
				case 0:
					LendingsUi.showLendingsUi();
					break;
					
				case 1:
				//option to insert lendings
				//AddLendingMenu.showAddLendingMenu();
					break;
					
				case 2: 
				// option to modify / edit lendings
				//	EditLendingUi.showEditLendingUi();

					break;
				
				case 3:
					// option to delete lendings  
					//DeleteLendingMenu.showDeleteLendingMenu();
					break;
				}

			} while (option != 0 && option != 1 && option != 2 && option != 3);
			
		}//showLendingDetailsOptions()
	}//class LendingDetailsMenu	