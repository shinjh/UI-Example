# 1. Project Guideline

## 1.1 File naming

### 1.1.1 Resources files

#### 1.1.1.1 Drawable files

Naming conventions for drawables:

| Asset Type   | Prefix             |		Example           |
|--------------|--------------------|-----------------------------|
| Icon         | `ic_`	            | `ic_star.png`               |
| Button       | `btn_`	            | `btn_apply.png`    	  |

Naming conventions for icons:

| Asset Type                      | Prefix             | Example                      |
| --------------------------------| -------------------| ---------------------------- |
| Icons                           | `ic_`              | `ic_arrow.png`               |
| Launcher icons                  | `ic_launcher`      | `ic_launcher_mycelebs.png`   |

Naming conventions for selector states:

| State	       | Suffix          | Example                   |
|--------------|-----------------|---------------------------|
| Normal       | `_normal`       | `btn_save_normal.png`     |
| Pressed      | `_pressed`      | `btn_save_pressed.png`    |
| Focused      | `_focused`      | `btn_save_focused.png`    |
| Disabled     | `_disabled`     | `btn_save_disabled.png`   |
| Selected     | `_selected`     | `btn_save_selected.png`   |


#### 1.1.1.2 Layout files

Naming conventions for Components:
{component name}_{name}

| Component        | Class Name             		| Layout Name                   	|
| ---------------- | ---------------------------------- | ------------------------------------- |
| Activity         | `UserProfileActivity`  		| `activity_user_profile.xml`   	|
| Fragment         | `SignUpFragment`       		| `fragment_sign_up.xml`        	|
| FragmentDialog   | `ChangePasswordFragmentDialog` 	| `fragment_dialog_change_password.xml` |
| Dialog           | `ChangePasswordDialog` 		| `dialog_change_password.xml` 		|
| Viewholder       | `HomePictureViewHolder`            | `viewholder_home_picture.xml`         |
| CustomView       | `TitleBar`                    	| `view_title_bar.xml`	     	  	|
| Keytalk 	   |                     		| `keytalk_finder.xml`	     	  	|
| Partial layout   |                     		| `partial_bottom_sheet_top.xml`       	|

#### 1.1.1.3 Layout resources

Naming conventions for Resource Components:

| Component        | Resource ID             		
| ---------------- | ---------------------------|
| CustomView       | `ct_`  			|
| View		   | `v_`       		|
| ImageView	   | `iv_`       		|
| TextView	   | `tv_`       		|
| RecyclerView	   | `rc_`       		|
| Include layout   | `il_`       		|

#### 1.1.1.4 Values files

Resource files in the values folder should be __plural__, e.g. `strings.xml`, `styles.xml`, `colors.xml`, `dimens.xml`, `attrs.xml`

# License

```
Copyright 2019 Mycelebs corp.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
