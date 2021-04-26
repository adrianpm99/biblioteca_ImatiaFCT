package com.imatia.bookmanager.view.menus;

import com.imatia.bookmanager.view.inputs.InputUserData;
import com.imatia.bookmanager.view.ui.SearchLendingUi;
import com.imatia.bookmanager.view.ui.StartMenuUI;




	public class LendingsMenu {
		public static void showLendingsOptions() {

			int option;

			do {
				option = Integer.parseInt(InputUserData.checkUserInput("option"));

				switch (option)
				{
				case 0:
					StartMenuUI.showStartMenuUi();
					break;
					
				case 1:
				//option to insert lendings
				AddLendingMenu.showAddLendingMenu();
					break;
					
				case 2: 
				// option to search lendings
				SearchLendingUi.showSearchLendingUi();

					break;
				
				case 3:
					// option to delete lendings  
					DeleteLendingMenu.showDeleteLendingMenu();
					break;
				}

			} while (option != 0 && option != 1 && option != 2 && option != 3);
			
		}//showLendingDetailsOptions()
	}//class LendingDetailsMenu	