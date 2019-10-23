## FrontEnd

### 一.HTML

### 1.基本方法及首页设计——Practice

#### 预期

1. 文本内容，包括标题、加粗、斜体等
2. 表格内容，包括表格样式、背景、图片添加等
3. 表单内容，包括输入框、单选框、下拉框、提交按钮等

#### 实现

```html
<!DOCTYPE html>
<html>
<head>
	<title>League of Legends</title>
</head>
<body>
	<!-- 游戏简介部分 -->
	<div>
		<h1>英雄联盟</h1>
		<h2>游戏简介</h2>
		<font color=#23282D>
		<b>《英雄联盟》(简称lol)是由美国<i>Riot Game</i>开发，由腾讯代理</b>
		<br>
		<br>
		<b>《英雄联盟》还致力于推动全球电子竞技的发展，除了联动各赛区发展职业联赛、打造电竞体系之外，每年还会举办“季中冠军赛”“全球总决赛”“All Star全明星赛”三大世界级赛事，获得了亿万玩家的喜爱，形成了自己独有的电子竞技文化。<ins>[1]</ins></b>
		<br>
		<br>
		<b>英雄联盟是一款多人竞技类游戏，于<del>2017</del>2018年加入亚运会。</b>
		</font>
		<HR align=left width="80%" color=E6E6E6 SIZE=2>
	</div>

	<!-- 英雄简介部分 -->
	<div>
		<h2>技能简介</h2>
		<h4>虚空之女</h4>
		<font color=#23282D>
		<table border="1" bgcolor=#F8F8F8 width="800" bordercolor="#E6E6E6" cellspacing="0" cellpadding="2" style="border-collapse:collapse;">
			<tr>
				<!-- 表头项 -->
				<td width="120"><b>技能名</b></td>
				<td width="50"><b>触发</b></td>
				<td width="200"><b>技能属性</b></td>
				<td width="350"><b>技能效果</b></td>
				<td width="80"><b>图标</b></td>
			</tr>
			<!-- 被动技能 -->
			<tr>
				<td valign="middle">体表活肤</td>
				<td valign="middle">被动</td>
				<td colspan="2">卡莎的普通攻击会叠加电浆，持续4秒，造成额外4/5/6/7/8/9/10（1/4/8/12/16级时）（+1/2/3/4/5[1/3/6/9/11/14/17级时]每层电浆）（+0.1/0.125/0.15/0.175/0.2AP[1/2/3/4/5层电浆效果时]）的魔法伤害。<br>
				电浆效果达到4层后，卡莎的下一次攻击将会造成电浆破裂，根据敌人已损失的生命值15%（+2.5%/100AP）造成伤害。对野怪的最高伤害为400。友军的定身效果也可以帮忙叠加电浆。<br>
				此外，卡莎可通过购买装备来升级她的基础技能，让它们拥有更多强大的属性。</td>
				<td align="center" valign="middle"><img src="pics/passive.png"></td>
			</tr>
			<!-- Q技能 -->
			<tr>
				<td valign="middle">艾卡西亚暴雨</td>
				<td valign="middle">Q</td>
				<td>消耗：55法力<br>
					冷却时间：10/9/8/7/6<br>
					射程：600
				</td>
				<td>
					卡莎发射6发弹体并在附近的敌人中间四散，造成45/61.25/77.5/93.75/110（+0.4AD）（+0.4AP）物理伤害。有额外的弹体命中相同英雄时，会造成30%伤害。<br>
					活体武器 -100额外攻击力 - 艾卡西亚暴雨发射10发弹体。<br>
					低于35%生命值的小兵会受到200%伤害。
				</td>
				<td align="center" valign="middle"><img src="pics/Q.png"></td>
			</tr>
			<!-- W技能 -->
			<tr>
				<td valign="middle">虚空索敌</td>
				<td valign="middle">W</td>
				<td>目标射程：2500<br>
					消耗：55/60/65/70/75法力<br>
					冷却时间：22/20/18/16/14
				</td>
				<td>
					0.5秒延迟后，卡莎发射一道虚空震波，在命中第一个敌人时提供其真实视野4秒，造成20/45/70/95/120（+1.5AD）（0.6AP）魔法伤害，并施加2层电浆。<br>
					活体武器 -100法术强度 - 虚空索敌施加3层电浆并在命中英雄时返还50%冷却时间。
				</td>
				<td align="center" valign="middle"><img src="pics/W.png"></td>
			</tr>
			<!-- E技能 -->
			<tr>
				<td valign="middle">极限超载</td>
				<td valign="middle">E</td>
				<td>消耗：30法力<br>
					冷却时间：16/15.5/15/14.5/14
				</td>
				<td>
					卡莎花费1.2（-0.5%/1%额外攻击速度，最多减少50%）秒来极限超载她的虚空能量。她在超载蓄力期间获得55/60/65/70/75%（+1%/1%额外攻击速度，最高可以提高至110/120/130/140/150%）移动速度并在超载持续期间获得40/50/60/70/80%攻击速度，持续4秒。<br>
					活体武器-100%攻击速度 - 极限超载提供隐形，持续0.5秒。<br>
					普通攻击会使极限超载的冷却时间减少0.5秒。可通过攻击速度来改进极限超载的施放时间和移动速度加成。
				</td>
				<td align="center" valign="middle"><img src="pics/E.png"></td>
			</tr>
			<!-- R技能 -->
			<tr>
				<td valign="middle">猎手本能</td>
				<td valign="middle">R</td>
				<td>目标射程：1500/2000/2500<br>
					消耗：100法力<br>
					冷却时间：110/90/70<br>
					距离：525
				</td>
				<td>
					卡莎跃迁到一个位置上，该位置处于一名身上带有电浆效果的敌方英雄的附近，并获得一个可吸收75/100/125（+1/1.5/2AD）（+0.75AP）伤害的护盾，该护盾持续2秒。
				</td>
				<td align="center" valign="middle"><img src="pics/R.png"></td>
			</tr>
		</table>
		<br>
		<HR align=left width="80%" color=E6E6E6 SIZE=2>
		</font>
	</div>

	<!-- 登陆模块 -->
	<div>		
		<h2>用户注册</h2>
	<font color=#23282D>
		<form method="get" action="http://how2j.cn/study/login.jsp">
			账号：<input type="text" name="name">
			<font color="red">账号不得少于3个字符</font><br>
			<br>
			密码：<input type="password" name="password"><br>
			<br>
			性别
			<input type="radio" name="gender" checked="checked">男
			<input type="radio" name="gender">女<br>
			<br>
			证件：<select>
				<option>身份证</option>
				<option>港澳通行证</option>
				<option>军官证</option>
			</select><br>
			<br>
			偏好位置：<br>
			<input type="checkbox" name="position">Top<br>
			<input type="checkbox" name="position">Mid<br>
			<input type="checkbox" name="position">Jungle<br>
			<input type="checkbox" name="position">ADC<br>
			<input type="checkbox" name="position">Sup<br>
			<br>
			<input type="submit" name="">
		</form>
	</font>
	</div>
</body>
</html>

```

#### 索引

- toyz/Package/FrontEnd/HTML/TestPrimary.html