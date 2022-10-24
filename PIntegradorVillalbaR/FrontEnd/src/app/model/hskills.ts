export class HSkills {
  id?: number;
  namehs?: string;
  percentage?: String;
  icon?: string;
  color?: string;

  constructor(namehs: string, percentage: String, icon: string, color: string) {
    this.namehs = namehs;
    this.percentage = percentage;
    this.icon = icon;
    this.color = color;
  }
}
