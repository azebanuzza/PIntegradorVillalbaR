export class SSkills {
  id?: number;
  namess?: string;
  percentage?: String;
  icon?: string;
  color?: string;

  constructor(namess: string, percentage: String, icon: string, color: string) {
    this.namess = namess;
    this.percentage = percentage;
    this.icon = icon;
    this.color = color;
  }
}
