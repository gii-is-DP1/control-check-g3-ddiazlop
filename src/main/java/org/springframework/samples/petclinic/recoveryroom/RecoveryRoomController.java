package org.springframework.samples.petclinic.recoveryroom;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RecoveryRoomController {
    
	private static final String VIEWS_RECOVERY_ROOM_FORM = "recoveryroom/createOrUpdateRecoveryRoomForm";

	private final RecoveryRoomService recoveryRoomService;
	
	@Autowired
	public RecoveryRoomController(RecoveryRoomService recoveryRoomServ) {
		this.recoveryRoomService = recoveryRoomServ;
	}

	@GetMapping(value = "/recoveryroom/create")
	public String initForm(ModelMap model) {
		RecoveryRoom recoveryRoom = new RecoveryRoom();
		model.put("recoveryRoom", recoveryRoom);
		recoveryRoom.setRoomType(this.recoveryRoomService.getRecoveryRoomType("room"));
		return VIEWS_RECOVERY_ROOM_FORM;
	}
	
	@PostMapping(value = "/recoveryroom/create")
	public String processCreationForm(@Valid RecoveryRoom recoveryRoom, BindingResult result) {
		if (result.hasErrors()) {
			return VIEWS_RECOVERY_ROOM_FORM;
		}else {
			this.recoveryRoomService.save(recoveryRoom);
			return "welcome";
		}
	}

}
