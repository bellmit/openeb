package com.gsccs.b2c.plat.site.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gsccs.b2c.plat.site.service.ChannelService;
import com.gsccs.eb.api.domain.goods.Category;
import com.gsccs.eb.api.domain.site.Channel;
import com.gsccs.eb.api.utils.JsonMsg;

/**
 * 栏目管理
 */
@Controller
@RequestMapping("/channel")
public class ChannelController {

	@Autowired
	private ChannelService channelService;

	/**
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model) {
		List<Channel> channelList = channelService.findSubChannel(0l);
		model.addAttribute("channelList", channelList);
		return "site/channel-list";
	}

	/**
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/form", method = RequestMethod.GET)
	public String channelForm(Long id,Long parid, Model model) {
		Channel channel = null;
		String view = "site/channel-add";
		if (null != id) {
			view = "site/channel-edit";
			channel = channelService.findById(id);
		}else{
			channel = new Channel();
			channel.setParid(parid);
		}
		model.addAttribute("channel", channel);
		model.addAttribute("channelTree", channelService.findChannelTree(0l));
		return view;
	}

	/**
	 * 保存栏目信息
	 * 
	 * @param floor
	 * @param map
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public JsonMsg channelSave(Channel channel, ModelMap map,
			HttpServletRequest request) {
		JsonMsg jsonMsg = new JsonMsg();
		if (null == channel) {
			jsonMsg.setSuccess(false);
			return jsonMsg;
		}
		channelService.insert(channel);
		jsonMsg.setSuccess(true);
		return jsonMsg;
	}

	
	@RequestMapping(value = "/child", method = RequestMethod.GET)
	@ResponseBody
	public List<Channel> child(Long id) {
		List<Channel> channelList = channelService.findSubChannel(id);
		return channelList;
	}
	
	@RequestMapping(value = "/validName", method = RequestMethod.GET)
	@ResponseBody
	public Boolean validName(String name) {
		return true;
	}

}
